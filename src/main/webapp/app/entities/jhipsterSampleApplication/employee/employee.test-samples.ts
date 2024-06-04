import dayjs from 'dayjs/esm';

import { IEmployee, NewEmployee } from './employee.model';

export const sampleWithRequiredData: IEmployee = {
  id: 11339,
};

export const sampleWithPartialData: IEmployee = {
  id: 29502,
  firstName: 'Francis',
  lastName: 'Macejkovic',
  email: 'Freddy79@yahoo.com',
  hireDate: dayjs('2024-06-04T08:19'),
  salary: 20445,
};

export const sampleWithFullData: IEmployee = {
  id: 9712,
  firstName: 'Odessa',
  lastName: 'Smitham',
  email: 'Manuel40@gmail.com',
  phoneNumber: 'constant',
  hireDate: dayjs('2024-06-04T00:10'),
  salary: 29321,
  commissionPct: 22057,
};

export const sampleWithNewData: NewEmployee = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
