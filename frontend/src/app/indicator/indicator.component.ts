import { Component, OnInit, Input } from '@angular/core';
import { GraphComponent} from "../graph/graph.component";
import { DataService } from "../data.service";

@Component({
  selector: 'app-indicator',
  templateUrl: './indicator.component.html',
  styleUrls: ['./indicator.component.css']
})
export class IndicatorComponent implements OnInit {
  @Input() country: string;
  categories: any;
  ageGroups: any;
  graphInfo: {};
  selectedCategory: any;
  selectedAgeGroup: any;

  constructor(private _dataService: DataService) { }

  ngOnInit() {
    this.categories = this._dataService.getCategories();
    this.ageGroups = this._dataService.getAgeGroups();
  }

  updateGraphInfo() {
    if (!this.selectedCategory || !this.selectedAgeGroup) {
      return;
    }

    this.graphInfo = this._dataService.getInfoByCategoryAndAgeGroup(
      this.selectedCategory, this.selectedAgeGroup);
    console.log(this.graphInfo);
  }

  selectCategory(category) {
    this.selectedCategory = category;
    this.updateGraphInfo();
  }

  selectAgeGroup(ageGroup) {
    this.selectedAgeGroup = ageGroup;
    this.updateGraphInfo();
  }
}
