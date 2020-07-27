import { Component, OnInit } from '@angular/core';
import { ExpenseClaimedService } from '../ExpenseClaimedService';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  code:number
  constructor(public expenseClaimedService : ExpenseClaimedService) { 
    this.code=undefined
  }

  ngOnInit() {
  }

  searchExpenseById(){
    if(this.code!=null)
    this.expenseClaimedService.getExpenseClaims(this.code).subscribe(data=> { this.expenseClaimedService.claimNo=data; //console.log(data)
    })
  }

}
