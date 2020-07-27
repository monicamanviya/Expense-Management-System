import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExpenseClaimedService } from '../ExpenseClaimedService';
import { ExpenseClaimed } from 'src/model/ExpenseClaimed';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from '../EmployeeService';
import { Project } from 'src/model/Project';
import { ProjectService } from '../ProjectService';
import { Expense } from 'src/model/Expense';
import { ExpenseService } from '../ExpenseService';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
  providers: [DatePipe]
})
export class UpdateComponent implements OnInit {
  alertMsg: string
  updateIndex: number;
  claims:[];
  updatedExpenseClaimed: ExpenseClaimed
  claimed:ExpenseClaimed
  myform:FormGroup;
  projects: Project[]
  Expenses:Expense[]
  myDate=new Date();
  curDate:string;
  // code:number;
  // expenses:Expense[];
  // expense_type : string
  // flag: number
  

  constructor(private router: Router, public expenseClaimedService: ExpenseClaimedService,private formBuilder:FormBuilder,
    public employeeService: EmployeeService, public projectService:ProjectService,  public expenseService: ExpenseService, private datePipe:DatePipe) {
      this.curDate = this.datePipe.transform(this.myDate, 'yyyy-MM-dd');
      //console.log(this.curDate)
    
    this.alertMsg=''
   }

   get f() { return this.myform.controls; }

  dateLessThan(from: string, to: string) {
    return (group: FormGroup): {[key: string]: any} => {
      let f = group.controls[from];
      let t = group.controls[to];
      if (f.value > t.value) {
        return {
          dates: "End date must be after Start date"
        };
      }
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
    }}

   
   getExpenseById(){
    if(this.updateIndex){
     this.expenseClaimedService.getExpenseClaims(this.updateIndex).subscribe(data=> { this.expenseClaimedService.claimed=data;})
      
    }

   }

  
 

   updateExpenseClaimed() {
    this.expenseClaimedService.updateExpenseClaimed()
    this.expenseClaimedService.updateExpenseClaimed().subscribe((data: ExpenseClaimed) => { this.claimed = data; });
    alert('Updated Successfully')
    this.updateIndex=null
  }

  ngOnInit() {
    this.myform = this.formBuilder.group({
      code: [''],
      empId: [''],
      projectcode: [''],
      expensecode: [''],   
      start: [''],
      end: [''],
      amount: ['', [Validators.required, Validators.min(1000),Validators.max(100000)]]
  }, {validator: this.dateLessThan('start', 'end')})
  this.projectService.getAll().subscribe(res => {
    this.projects = res;
  });
  this.expenseService.getAll().subscribe(res =>{
    this.Expenses=res;
  });
  }

//   getAll()
//     {
//         this.expenseService.getAll().subscribe(res => {
//             this.expenses = res;
//             res.forEach(element => {
//                 if(element.expense_type==this.expense_type)
//                 {
//                 this.code=element.expense_code;
//                 console.log( this.code)
//                 this.getFunction();
//                 }
//             });
//           });
//           console.log(this.expenses)
//     }

//     getFunction() {
//       if(this.code != null){
//          console.log(this.expense_type)
//          console.log(this.code)
//          this.expenseService.getExpenseByCode(this.code).subscribe(data => {this.expenseService.Expenses = data;console.log(this.expenseService.Expenses)})
//          this.flag=1
//      }
//      else{
//      console.log("Cannot be empty")
//      }
//  }

//  getExpenseCodeByType(){
//   this.expenseService.getAll().subscribe(res => {
//     this.expenses = res;
//     res.forEach(element => {
//         if(element.expense_code==this.expenseClaimedService.claimed.expenseId)
//         {
//         this.expense_type=element.expense_type;
//         console.log( this.code)
//         // this.getFunction();
//         }
//     });
//   });
//  }
  


 

}
