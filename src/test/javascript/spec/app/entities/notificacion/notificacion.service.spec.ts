/* tslint:disable max-line-length */
import axios from 'axios';
import { format } from 'date-fns';

import * as config from '@/shared/config/config';
import { DATE_TIME_FORMAT } from '@/shared/date/filters';
import NotificacionService from '@/entities/notificacion/notificacion.service';
import { Notificacion } from '@/shared/model/notificacion.model';

const mockedAxios: any = axios;
jest.mock('axios', () => ({
  get: jest.fn(),
  post: jest.fn(),
  put: jest.fn(),
  delete: jest.fn()
}));

describe('Service Tests', () => {
  describe('Notificacion Service', () => {
    let service: NotificacionService;
    let elemDefault;
    let currentDate: Date;
    beforeEach(() => {
      service = new NotificacionService();
      currentDate = new Date();

      elemDefault = new Notificacion('ID', 'AAAAAAA', 'AAAAAAA', currentDate, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            fechaEnvio: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        mockedAxios.get.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.find('123').then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });
      it('should create a Notificacion', async () => {
        const returnedFromService = Object.assign(
          {
            id: 'ID',
            fechaEnvio: format(currentDate, DATE_TIME_FORMAT)
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            fechaEnvio: currentDate
          },
          returnedFromService
        );

        mockedAxios.post.mockReturnValue(Promise.resolve({ data: returnedFromService }));
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should update a Notificacion', async () => {
        const returnedFromService = Object.assign(
          {
            destinatarios: 'BBBBBB',
            remitente: 'BBBBBB',
            fechaEnvio: format(currentDate, DATE_TIME_FORMAT),
            asunto: 'BBBBBB',
            mensaje: 'BBBBBB',
            cc: 'BBBBBB',
            cco: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            fechaEnvio: currentDate
          },
          returnedFromService
        );
        mockedAxios.put.mockReturnValue(Promise.resolve({ data: returnedFromService }));

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });
      it('should return a list of Notificacion', async () => {
        const returnedFromService = Object.assign(
          {
            destinatarios: 'BBBBBB',
            remitente: 'BBBBBB',
            fechaEnvio: format(currentDate, DATE_TIME_FORMAT),
            asunto: 'BBBBBB',
            mensaje: 'BBBBBB',
            cc: 'BBBBBB',
            cco: 'BBBBBB'
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            fechaEnvio: currentDate
          },
          returnedFromService
        );
        mockedAxios.get.mockReturnValue(Promise.resolve([returnedFromService]));
        return service.retrieve({ sort: {}, page: 0, size: 10 }).then(res => {
          expect(res).toContainEqual(expected);
        });
      });
      it('should delete a Notificacion', async () => {
        mockedAxios.delete.mockReturnValue(Promise.resolve({ ok: true }));
        return service.delete('123').then(res => {
          expect(res.ok).toBeTruthy();
        });
      });
    });
  });
});
