import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import {NgxChartsModule} from '@swimlane/ngx-charts';
import { Ng4DropdownModule } from 'ng4-material-dropdown';


import { AppComponent } from './app.component';
import { MapComponent } from './map/map.component';
import { IndicatorComponent } from './indicator/indicator.component';
import { GraphComponent } from './graph/graph.component';
import { DataService } from './data.service';


@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    IndicatorComponent,
    GraphComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NgxChartsModule,
    Ng4DropdownModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
