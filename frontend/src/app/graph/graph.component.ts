import { Component, OnInit } from '@angular/core';
import {NgxChartsModule} from '@swimlane/ngx-charts';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {

  single: any[];
  multi: any[];

  view: any[] = [700, 400];

  // options
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Women who...';
  showYAxisLabel = true;
  yAxisLabel = 'Percentage';

  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };

  constructor() {
  }

  onSelect(event) {
    console.log(event);
  }

  ngOnInit() {
    this.single = [
      {
        "name": "go to school",
        "value": 30
      },
      {
        "name": "graduate",
        "value": 5
      }
    ]
  }

}
