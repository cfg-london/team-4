import { Injectable } from '@angular/core';

@Injectable()
export class DataService {
  categoryInfo: any;

  constructor() {
    this.categoryInfo = {}
  }

  getCountries() {
    return ['El Salvador', 'Senegal', 'India'];
  }

  getCategories() {
    return ['Education', 'Family', 'Health'];
  }

  getInfoByCategory(category: string) {
    if (this.categoryInfo[category]) {
      console.log("Return cached info for " + category);
      return this.categoryInfo[category];
    }
    //make get request
    this.categoryInfo[category] = [
      ['indicator1', {
        '15-19': '20',
        '20-29': '22',
        '30-39': '5'
      }],
      ['indicator2', {
        '15-19': '4',
        '30-39': '6'
      }]
    ];

    return [
      ['indicator1', {
        '15-19': '20',
        '20-29': '22',
        '30-39': '5'
      }],
      ['indicator2', {
        '15-19': '4',
        '30-39': '6'
      }]
      ];
  }

  getAgeGroups() {
    return ['15-19', '20-29', '30-39', '40-49'];
  }

  // // list of [indicatorname, percentage]
  getInfoByCategoryAndAgeGroup(category: string, ageGroup: string) {

    return this.getInfoByCategory(category).map(info => [info[0], info[1][ageGroup]]); //.filter != 0
  }
}
