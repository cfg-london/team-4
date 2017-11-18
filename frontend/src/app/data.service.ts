import { Injectable } from '@angular/core';

@Injectable()
export class DataService {
  categoryInfo: any;

  constructor() {
    this.categoryInfo = {
      'Sex Education': [
          ['are using contraception', {
          '15-19': '50',
          '20-29': '73.5',
          '30-39': '82.6'
          }],
          ['are circumcised', {
            '15-19': '2',
            '20-29': '12',
            '30-39': '20'
          }],
          ['experienced sexual violence before 18', {
            '15-19': '37.4',
            '20-29': '24.4',
            '30-39': '40.2'
          }],
          ['died after childbirth', {
            '15-19': '5.2',
            '20-29': '2.3',
            '30-39': '3.7'
          }],
      ],
      'Education': [
        ['are literate', {
          '15-19': '44.9',
          '20-29': '42.1',
          '30-39': '40.8'
        }],
        ['worked in the last 12 months', {
          '15-19': '29',
          '20-29': '51.5',
          '30-39': '60.4'
        }],
        ['attended secondary or higher education', {
          '15-19': '91',
          '20-29': '80',
          '30-39': '59.9'
        }],
        ['attended school regurarly', {
          '15-19': '41.5',
          '20-29': '64.7',
          '30-39': '33.9'
        }]
      ],
      'Family': [
        ['victim of domestic violence', {
          '15-19': '14.6',
          '20-29': '22.4',
          '30-39': '24.5'
        }],
        ['who decide what to do with their earnings', {
          '15-19': '59.6',
          '20-29': '60.7',
          '30-39': '67.3'
        }],
        ['beaten justified for one specific reason', {
          '15-19': '2',
          '20-29': '2.3',
          '30-39': '2.7'
        }],
        ['earn more money than husband', {
          '15-19': '9.3',
          '20-29': '15.2',
          '30-39': '18.3'
        }]
      ]
    };
  }

  getCountries() {
    return ['El Salvador', 'Senegal', 'India'];
  }

  getCategories() {
    return ['Education', 'Family', 'Sex Education'];
  }

  getInfoByCategory(category: string) {
      return this.categoryInfo[category];
  }

  getAgeGroups() {
    return ['15-19', '20-29', '30-39'];
  }

  // // list of [indicatorname, percentage]
  getInfoByCategoryAndAgeGroup(category: string, ageGroup: string) {
    console.log("getting info for "+ category + " and " + ageGroup);
    return this.getInfoByCategory(category).map(info => {
      console.log(info[1][ageGroup]);
      return {
        "name"
      :
        info[0],
          "value"
      :
        info[1][ageGroup]
      }
    }); //.filter != 0
  }
}
