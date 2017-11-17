import { Component, OnInit, Input } from '@angular/core';
import { GraphComponent} from "../graph/graph.component";

@Component({
  selector: 'app-indicator',
  templateUrl: './indicator.component.html',
  styleUrls: ['./indicator.component.css']
})
export class IndicatorComponent implements OnInit {
  @Input() country: string;

  constructor() { }

  ngOnInit() {
  }

}
