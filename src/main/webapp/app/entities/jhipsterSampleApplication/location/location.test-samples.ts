import { ILocation, NewLocation } from './location.model';

export const sampleWithRequiredData: ILocation = {
  id: 10445,
};

export const sampleWithPartialData: ILocation = {
  id: 14120,
  streetAddress: 'fiercely facilitate queasily',
  city: 'Lake Jayceehaven',
};

export const sampleWithFullData: ILocation = {
  id: 23469,
  streetAddress: 'negative',
  postalCode: 'pickax before as',
  city: 'Boscohaven',
  stateProvince: 'contextualise pike lapse',
};

export const sampleWithNewData: NewLocation = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
