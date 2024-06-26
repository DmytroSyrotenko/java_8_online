import {Component, OnDestroy, OnInit} from '@angular/core';
import {LoginService} from "../../services/login.service";
import {Observable, Subscription} from "rxjs";
import {Router} from "@angular/router";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {CartEntry} from "../../models/cart/cart-entry";
import {CartService} from "../../services/cart.service";
import {Cart} from "../../models/cart/cart";

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [
    AsyncPipe,
    NgForOf,
    NgIf,
    JsonPipe
  ],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss'
})
export class CartComponent implements OnInit,OnDestroy{

  private _subscription= new Subscription();
  constructor(
    private _authService:LoginService,
    private _router: Router,
    private _cartService:CartService
  ) {
  }

  cart$:Observable<Cart>= this._cartService.getCart();//TODO нужно ли вносить в подписку чтобы потом отписаться


  ngOnInit(): void {//проверка что залогинен перед действиями в карте
    this._subscription.add(
      this._authService.isLoggedIn()
        .subscribe(isLoggedIn=>{
          if(!isLoggedIn){
            this._router.navigateByUrl('/plp')
          }
          }
        )
    )
  }

  createOrder():void{
    this._subscription.add(
      this._cartService.createOrder().subscribe(
        () => this._router.navigateByUrl('/plp'),
        (error)=>console.log('error', error)
      ))
  }

  deleteItem(productVariantId: number):void{
    this._subscription.add(
      this._cartService.deleteItem(productVariantId).subscribe(
       () => this._router.navigateByUrl('/cart').then(() => {
                                                          window.location.reload();
                                                        }),
       (error)=>console.log('error', error)
     ))
  }


  ngOnDestroy(): void {
    this._subscription.unsubscribe()
  }

}
