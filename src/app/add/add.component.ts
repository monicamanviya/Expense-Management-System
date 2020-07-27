import { Component, OnInit, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../EmployeeService';
import { Employee } from 'src/model/Employee'
import { ProjectService } from '../ProjectService';
import { Project } from 'src/model/Project';
import { ExpenseClaimedService } from '../ExpenseClaimedService';
import { ExpenseClaimed } from 'src/model/ExpenseClaimed';
import { ExpenseService } from '../ExpenseService';
import { Expense } from 'src/model/Expense';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers: [DatePipe]
})

@Injectable()
export class AddComponent implements OnInit {

  expense_code: number   // 3
  employeeId: number;  // 1
  claimed: ExpenseClaimed;
  addNewClaim: ExpenseClaimed
  employees: Employee[];
  projectCode: number; //2
  flag: number
  projects: Project[]
  Expenses: Expense[]
  startDate: Date  //4
  endDate: Date  //5
  expenseAmt: number //6
  temp: number
  myform: FormGroup;
  alertMessage: string = this.temp + ' is Added successfully';
  check: boolean
  myDate = new Date();
  curDate: string;
  //changed
  code: number;
  expenses: Expense[];
  expense_type: string


  constructor(private router: Router, public employeeService: EmployeeService, public projectService: ProjectService, public expenseService: ExpenseService,
    public expenseClaimedService: ExpenseClaimedService, private formBuilder: FormBuilder, private datePipe: DatePipe) {
    this.curDate = this.datePipe.transform(this.myDate, 'yyyy-MM-dd');
    //console.log(this.curDate)
  }

  get f() { return this.myform.controls; }

  dateLessThan(from: string, to: string) {
    return (group: FormGroup): { [key: string]: any } => {
      let f = group.controls[from];
      let t = group.controls[to];
      if (f.value > t.value) {
        return {
          dates: "End date must be after Start date"
        };
      }
      //console.log(f.value);
      // console.log(this.curDate)
      // console.log(f.value > this.curDate)
      if (f.value > this.curDate) {
        return {
          dates1: "Can't enter future date"
        };
      }
      if (t.value > this.curDate) {
        return {
          dates2: "Can't enter future date"
        };
      }
      return {};
    }
  }



  ngOnInit() {
    this.myform = this.formBuilder.group({
      empId: ['', Validators.required],
      projectcode: ['', Validators.required],
      expensecode: ['', Validators.required],
      start: ['', [Validators.required]],//Validators.pattern(/^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2}$/)
      end: ['', Validators.required],
      amount: ['', [Validators.required, Validators.min(1000), Validators.max(100000)]]
    }, { validator: this.dateLessThan('start', 'end') },

    )



    this.projectService.getAll().subscribe(res => {
      this.projects = res;
    });
    //changed name
    this.expenseService.getAll().subscribe(data => { this.Expenses = data;// console.log(data)
     });
  }

  selectEmployeeById() {
    if (this.employeeId != null) {
      this.employeeService.getEmployeeBYID(this.employeeId).subscribe(data => { this.employeeService.employees = data; //console.log(data) 
      });
    }
  }

  // getExpenseById() {
  //   this.expenseService.getExpenseByCode(this.expense_code).subscribe(data => { this.expenseService.Expenses[0] = data; });
  // }

  getProject() {
    if (this.projectCode != null) {
      // console.log(this.projectCode)
      this.projectService.getProjectBYID(this.projectCode).subscribe(data => this.projectService.Projects = data)
      this.flag = 1
      //console.log(this.flag)
    }
    else {
      //console.log("Cannot be empty")
    }
    //this.employeeID=null;
  }
  addExpenseClaimed() {
    this.addNewClaim = new ExpenseClaimed()
    this.addNewClaim.empId = this.employeeId
    this.addNewClaim.projectCode = this.projectCode
    this.addNewClaim.expenseId = this.code
    this.addNewClaim.startDate = this.startDate
    this.addNewClaim.endDate = this.endDate
    this.addNewClaim.expenseAmt = this.expenseAmt
    // console.log(this.addNewClaim)
    // console.log(this.startDate)
    this.expenseClaimedService.addExpenseClaimed(this.addNewClaim).subscribe(data => { this.temp = data; alert(data + ' is your expense code') });
    this.myform.reset()
    this.code = null
  }

  getAll() {
    this.expenseService.getAll().subscribe(res => {
      this.expenses = res;
      res.forEach(element => {
        if (element.expense_type == this.expense_type) {
          this.code = element.expense_code;
          // console.log( this.code)
          this.getFunction();
        }
      });
    });
    //console.log(this.expenses)
  }

  getFunction() {
    if (this.code != null) {
      //  console.log(this.expense_type)
      //  console.log(this.code)
      this.expenseService.getExpenseByCode(this.code).subscribe(data => {
        this.expenseService.Expenses = data;//console.log(this.expenseService.Expenses)
      })
        this.flag = 1
      }
     
    //  else {
    //       console.log("Cannot be empty")
    //     }
 
  }

  }