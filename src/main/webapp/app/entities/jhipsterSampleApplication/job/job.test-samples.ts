import { IJob, NewJob } from './job.model';

export const sampleWithRequiredData: IJob = {
  id: 22443,
};

export const sampleWithPartialData: IJob = {
  id: 8933,
};

export const sampleWithFullData: IJob = {
  id: 22509,
  jobTitle: 'Human Markets Manager',
  minSalary: 817,
  maxSalary: 28453,
};

export const sampleWithNewData: NewJob = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
