import axios from 'axios';

import buildPaginationQueryOpts from '@/shared/sort/sorts';

import { INotificacion } from '@/shared/model/notificacion.model';

const baseApiUrl = 'api/notificacions';

export default class NotificacionService {
  public find(id: string): Promise<INotificacion> {
    return new Promise<INotificacion>(resolve => {
      axios.get(`${baseApiUrl}/${id}`).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public retrieve(paginationQuery?: any): Promise<any> {
    return new Promise<any>(resolve => {
      axios.get(baseApiUrl + `?${buildPaginationQueryOpts(paginationQuery)}`).then(function(res) {
        resolve(res);
      });
    });
  }

  public delete(id: string): Promise<any> {
    return new Promise<any>(resolve => {
      axios.delete(`${baseApiUrl}/${id}`).then(function(res) {
        resolve(res);
      });
    });
  }

  public create(entity: INotificacion): Promise<INotificacion> {
    return new Promise<INotificacion>(resolve => {
      axios.post(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }

  public update(entity: INotificacion): Promise<INotificacion> {
    return new Promise<INotificacion>(resolve => {
      axios.put(`${baseApiUrl}`, entity).then(function(res) {
        resolve(res.data);
      });
    });
  }
}
