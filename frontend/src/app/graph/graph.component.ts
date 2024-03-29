import { Component, OnInit, Input } from '@angular/core';
import {NgxChartsModule} from '@swimlane/ngx-charts';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit {

  @Input() data: object;

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
    domain: ['#55BAB2', '#07509B', '#700370', '#172138']
  };

  constructor() {
  }

  onSelect(event) {
    console.log(event);
  }

  ngOnInit() {
    this.data = [];
  }

}
