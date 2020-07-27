import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { DeleteComponent } from './delete/delete.component';
import { SearchComponent } from './search/search.component';
import { UpdateComponent } from './update/update.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { EmployeeService } from './EmployeeService';
import { HttpClientModule } from '@angular/common/http'; 
import { ExpenseClaimedService } from './ExpenseClaimedService';
import { ExpenseService } from './ExpenseService';
import { ProjectService } from './ProjectService';

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    DeleteComponent,
    SearchComponent,
    UpdateComponent,
    NavbarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeService, ExpenseClaimedService,ExpenseService,ProjectService],
  bootstrap: [AppComponent]  
})
export class AppModule { }
