import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {httpConfig} from "../app.config";
import {Observable} from "rxjs";
import {ProductPlp} from "../models/product/product-plp";

@Injectable({
  providedIn: 'root'
})
export class PlpService {

  private _apiUrl: string = `${httpConfig.apiOpenUrl}/products/plp`;

  constructor(private _http: HttpClient) {
  }

  loadProducts(): Observable<ProductPlp[]> {
    return this._http.get<ProductPlp[]>(this._apiUrl);
  }

}
