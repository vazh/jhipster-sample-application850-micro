import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'region',
    data: { pageTitle: 'Regions' },
    loadChildren: () => import('./jhipsterSampleApplication/region/region.routes'),
  },
  {
    path: 'country',
    data: { pageTitle: 'Countries' },
    loadChildren: () => import('./jhipsterSampleApplication/country/country.routes'),
  },
  {
    path: 'location',
    data: { pageTitle: 'Locations' },
    loadChildren: () => import('./jhipsterSampleApplication/location/location.routes'),
  },
  {
    path: 'department',
    data: { pageTitle: 'Departments' },
    loadChildren: () => import('./jhipsterSampleApplication/department/department.routes'),
  },
  {
    path: 'task',
    data: { pageTitle: 'Tasks' },
    loadChildren: () => import('./jhipsterSampleApplication/task/task.routes'),
  },
  {
    path: 'employee',
    data: { pageTitle: 'Employees' },
    loadChildren: () => import('./jhipsterSampleApplication/employee/employee.routes'),
  },
  {
    path: 'job',
    data: { pageTitle: 'Jobs' },
    loadChildren: () => import('./jhipsterSampleApplication/job/job.routes'),
  },
  {
    path: 'job-history',
    data: { pageTitle: 'JobHistories' },
    loadChildren: () => import('./jhipsterSampleApplication/job-history/job-history.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
