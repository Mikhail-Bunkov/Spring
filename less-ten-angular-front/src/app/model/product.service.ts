import { Injectable } from '@angular/core';
import {Product} from "./product";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private identity: number = 6;
  constructor(public http: HttpClient) { }

  public findAll(){
    return this.http.get<Product[]>('/api/v1/product/all').toPromise();
    // return new Promise<Product[]>((resolve, reject) =>
    // {
    //   resolve(
    //     Object.values(this.products)
    //   )
    // })
  }

  public findById(id: number){
    return this.http.get<Product>(`/api/v1/product/${id}`).toPromise();
    // return new Promise<Product>((resolve, reject) =>
    // {
    //   resolve(
    //     this.products[id]
    //   )
    // })
  }

  public save(product: Product){
    if(product.id == -1) {
      product.id = NaN;
      return this.http.post<Product>('/api/v1/product', product).toPromise();
    }else{
      return this.http.put<Product>('/api/v1/product', product).toPromise();
    }
    // return new Promise<void>((resolve, reject) =>
    // {
    //   if(product.id == -1){
    //     product.id = this.identity++;
    //   }
    //   this.products[product.id] = product;
    //   resolve()
    // })
  }

  public delete(id: number){
    return this.http.delete<Product>(`/api/v1/product/${id}`).toPromise();
    // return new Promise<void>((resolve, reject) =>
    // {
    //   delete this.products[id];
    //   resolve()
    // })
  }
}
