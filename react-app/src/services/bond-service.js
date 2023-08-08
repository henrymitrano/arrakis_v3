import  http from './Axios-common';

export function getAllBonds(){

    return http.get("api/v1/bonds");


}