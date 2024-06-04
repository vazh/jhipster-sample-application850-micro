import { ITask, NewTask } from './task.model';

export const sampleWithRequiredData: ITask = {
  id: 31369,
};

export const sampleWithPartialData: ITask = {
  id: 18324,
  description: 'whoever separately',
};

export const sampleWithFullData: ITask = {
  id: 19636,
  title: 'wrongly',
  description: 'spree ack underneath',
};

export const sampleWithNewData: NewTask = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
