import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from 'src/model/Project';


@Injectable({
  providedIn: 'root'
})

export class ProjectService {
    Projects : Project[]
  newProject: Project
  updatedProject: Project
  Test: Observable<Project[]>

  constructor(public http: HttpClient) {
    this.Projects = []
  }
  // getEmployees() {
  //   return this.http.get<Employee[]>('http://localhost:8856/all')
  // }
  getProjectBYID(projectCode: number) {
    //console.log(employeeID)
    this.Test= this.http.get<Project[]>('http://localhost:8858/PLP/'+projectCode)
    if(this.Test!=null)
    {return this.http.get<Project[]>('http://localhost:8858/PLP/'+projectCode)}
  }
  getAll(): Observable<Project[]> {
      return this.http.get<Project[]>('http://localhost:8858/PLP/displayAll')
  }
}