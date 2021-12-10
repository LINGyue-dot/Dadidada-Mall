/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-09 14:38:27
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-10 02:00:23
 * @Description:
 */

import { UPLOAD_API } from "@/config";
import axios from "axios";
import { http } from ".";

export const UploadImg = async (file: any) => {
  const formData = new FormData();
  formData.append("file", file);
  return axios({
    url: `${UPLOAD_API}/upload`,
    method: "post",
    data: formData,
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });
  return fetch(`${UPLOAD_API}/upload`, {
    method: "POST",
    body: formData,
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });
};
