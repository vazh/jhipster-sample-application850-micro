import { IRegion, NewRegion } from './region.model';

export const sampleWithRequiredData: IRegion = {
  id: 22453,
};

export const sampleWithPartialData: IRegion = {
  id: 27628,
};

export const sampleWithFullData: IRegion = {
  id: 7995,
  regionName: 'whether not between',
};

export const sampleWithNewData: NewRegion = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
