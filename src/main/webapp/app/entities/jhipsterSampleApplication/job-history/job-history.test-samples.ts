import dayjs from 'dayjs/esm';

import { IJobHistory, NewJobHistory } from './job-history.model';

export const sampleWithRequiredData: IJobHistory = {
  id: 1897,
};

export const sampleWithPartialData: IJobHistory = {
  id: 27876,
  startDate: dayjs('2024-06-04T13:16'),
  language: 'FRENCH',
};

export const sampleWithFullData: IJobHistory = {
  id: 18386,
  startDate: dayjs('2024-06-04T14:25'),
  endDate: dayjs('2024-06-04T02:03'),
  language: 'ENGLISH',
};

export const sampleWithNewData: NewJobHistory = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
