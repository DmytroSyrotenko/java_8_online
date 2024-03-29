import {Injectable} from "@angular/core";
import {httpConfig} from "../app.config";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductPdp} from "../models/product/product-pdp";

@Injectable({
  providedIn: 'root'
})

export class PdpService {
  private _apiUrl: string = `${httpConfig.apiOpenUrl}/products/pdp`;

  constructor(private _http: HttpClient) {
  }

  loadProductVariants(productId:string): Observable<ProductPdp> {
    return this._http.get<ProductPdp>(`${this._apiUrl}/${productId}`);
  }
}
