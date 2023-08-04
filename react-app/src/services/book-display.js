import { hostNameUrl } from "../config/api";
import axios from "axios";

export const findBooks = () => {
  const books = axios.get(`${hostNameUrl}/book_1`);
  return books;
};