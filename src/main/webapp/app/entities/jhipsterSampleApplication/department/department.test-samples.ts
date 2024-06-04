import { IDepartment, NewDepartment } from './department.model';

export const sampleWithRequiredData: IDepartment = {
  id: 28111,
  departmentName: 'blah reassess hearty',
};

export const sampleWithPartialData: IDepartment = {
  id: 17128,
  departmentName: 'blah drat uh-huh',
};

export const sampleWithFullData: IDepartment = {
  id: 7976,
  departmentName: 'except baker reading',
};

export const sampleWithNewData: NewDepartment = {
  departmentName: 'via yuck',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
