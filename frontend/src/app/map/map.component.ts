import { Component, OnInit } from '@angular/core';
import { DataService} from "../data.service";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
  selectedCountry: any;
  countries: any;

  constructor(private _dataService: DataService) { }

  ngOnInit() {
    this.countries = this._dataService.getCountries();
    console.log(this.countries);
    this.selectedCountry = "";
  }

  selectCountry(country) {
    this.selectedCountry = country;
  }

}
