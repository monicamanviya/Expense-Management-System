import { Component, OnInit } from '@angular/core';
import { ExpenseClaimedService } from '../ExpenseClaimedService';
import { ExpenseClaimed } from 'src/model/ExpenseClaimed';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {
  code: number
  x: ExpenseClaimed
  alertMsg: string
  flag: boolean
  searchedClaim: ExpenseClaimed
  constructor(public expenseClaimedService: ExpenseClaimedService) {
    this.code = undefined
    this.alertMsg = ''
    this.flag = false
    this.searchedClaim=null
  }

  deleteById() {
    if (this.expenseClaimedService.getExpenseClaims(this.code)) {
      this.expenseClaimedService.deleteExpense(this.code).subscribe(data => { this.x = data; })
      this.code=undefined
      this.searchedClaim=null
      this.flag=true;
      alert('Deleted Successfully')
    }
  }

  findExpenseClaimById() {
    this.flag=false;
    //console.log(this.code)
    if (this.code) {
      this.expenseClaimedService.getExpenseClaims(this.code).subscribe(data => { this.searchedClaim = data; })
      //console.log(this.searchedClaim)
    }
  }

  ngOnInit() {
  }

}
