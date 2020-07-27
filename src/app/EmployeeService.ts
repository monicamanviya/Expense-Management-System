import { Employee } from 'src/model/Employee'
import { Observable } from 'rxjs/internal/Observable'
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ExpenseClaimedService } from './ExpenseClaimedService';

@Injectable()
export class EmployeeService {
    employees: Employee[]
    updatedEmployee: Employee
    test: Observable<Employee[]>
   
  
  
  
    constructor(public http: HttpClient) {
      this.employees = []
     
    }
    
    getEmployeeBYID(employeeId: number) {
      
      if(employeeId!=null){
        return this.http.get<Employee[]>('http://localhost:8856/'+employeeId)
        //return this.http.get<Employee[]>('http://3.82.56.5:8856/all')
      }
      
      
      
    }
  
  }