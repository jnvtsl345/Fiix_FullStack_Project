import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{ HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimeTableComponent } from './components/time-table/time-table.component';
import { UpdateStatusComponent } from './components/update-status/update-status.component';


@NgModule({
  declarations: [
    AppComponent,
    TimeTableComponent,
    UpdateStatusComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
