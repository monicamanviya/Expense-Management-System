import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ExpenseClaimed } from '../model/ExpenseClaimed';
import { Observable } from 'rxjs';
import { EmployeeService } from './EmployeeService';
import { Employee } from 'src/model/Employee';

@Injectable({

  providedIn: 'root'

})



export class ExpenseClaimedService {

  claimed: ExpenseClaimed
  updatedExpenseClaimed: ExpenseClaimed
  updatedIndex: number
  claimNo: ExpenseClaimed
  employees:Employee[]

  constructor(public http: HttpClient) {
    this.updatedExpenseClaimed = new ExpenseClaimed()
    this.updatedIndex = 0
  }

  getExpenseClaims(expenseCode: number) {
    //console.log(expenseCode)
    this.updatedIndex = expenseCode
    return this.http.get<ExpenseClaimed>('http://localhost:8857/view/' + expenseCode)

  }

  deleteExpense (expenseCode: number) : Observable<any>{
    //console.log(expenseCode)
    return this.http.delete<ExpenseClaimed>(`http://localhost:8857/delete/${expenseCode}`)
  }

  updateExpenseClaimed(): Observable<any> {
    //console.log(this.claimed)
    return this.http.put<ExpenseClaimed>(`http://localhost:8857/update/${this.updatedIndex}`, this.claimed);

  }

  addExpenseClaimed(newClaim:ExpenseClaimed) : Observable<any>{
    //console.log(newClaim)
    return this.http.post<ExpenseClaimed>('http://localhost:8857/add', newClaim);

  }
 


}

