import { Component } from '@angular/core';
import { MapComponent } from './map/map.component';
import { IndicatorComponent} from "./indicator/indicator.component";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
}
