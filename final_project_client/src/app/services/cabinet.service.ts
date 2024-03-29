import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {LoginService} from "./login.service";
import {httpConfig} from "../app.config";
import {UserInfo} from "../models/cabinet/user-info";
import {OrderInfo} from "../models/cabinet/order-info";


@Injectable({// аннотация бина в angular
  providedIn: "root" // чтобы был доступен везде
})

export class CabinetService {

  private _apiUrl: string = `${httpConfig.apiPersonalUrl}/cabinet`;
  private _apiUrlGetOrder: string = `${httpConfig.apiPersonalUrl}/order`;

  constructor(
    private _authService: LoginService,
    private _http: HttpClient
  ) {
  }

  getUserInfo(): Observable<UserInfo> {
    let headers = new HttpHeaders();
    let token = this._authService.getToken();
    headers = headers.set('Authorization', `Bearer ${token}`)//добавляем параметры в хттп-рек куда и как нам надо
    let options = {headers};
    return this._http.get<UserInfo>(this._apiUrl, options)
  }


  updateUserInfo(data: UserInfo): Observable<string> {
    let headers = new HttpHeaders();
    let token = this._authService.getToken();
    headers = headers.set('Authorization', `Bearer ${token}`)//добавляем параметры в хттп-рек куда и как нам надо
    let options = {headers};
    return this._http.post<string>(this._apiUrl, data, options)
  }

}
