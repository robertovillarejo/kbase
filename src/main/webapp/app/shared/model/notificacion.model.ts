export interface INotificacion {
  id?: string;
  destinatarios?: string;
  remitente?: string;
  fechaEnvio?: Date;
  asunto?: string;
  mensaje?: string;
  cc?: string;
  cco?: string;
}

export class Notificacion implements INotificacion {
  constructor(
    public id?: string,
    public destinatarios?: string,
    public remitente?: string,
    public fechaEnvio?: Date,
    public asunto?: string,
    public mensaje?: string,
    public cc?: string,
    public cco?: string
  ) {}
}
