import { DeleteComponent } from './delete/delete.component';
import { UpdateComponent } from './update/update.component';
import { SearchComponent } from './search/search.component';
import { AddComponent } from './add/add.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:'', component: HomeComponent},
  {path: 'add',component: AddComponent},
  {path: 'search',component: SearchComponent},
  {path: 'update',component: UpdateComponent},
  {path: 'delete',component: DeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
