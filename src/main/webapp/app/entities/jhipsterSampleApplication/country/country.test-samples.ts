import { ICountry, NewCountry } from './country.model';

export const sampleWithRequiredData: ICountry = {
  id: 31004,
};

export const sampleWithPartialData: ICountry = {
  id: 28091,
  countryName: 'triumphantly',
};

export const sampleWithFullData: ICountry = {
  id: 27122,
  countryName: 'pride wherever before',
};

export const sampleWithNewData: NewCountry = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
