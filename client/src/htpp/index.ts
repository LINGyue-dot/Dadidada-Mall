/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-07 16:57:44
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-08 23:32:11
 * @Description:
 */
import { BASE_API } from "@/config";

import qs from "qs";
import { BaseResponse } from "@/types/types";
import { Toast } from "vant";

export interface Config extends RequestInit {
  data?: any;
}

export const http = async (
  endpoint: string,
  { data, headers, ...customConfig }: Config = {},
  baseUrl: string = BASE_API
) => {
  let token = null;
  try {
    token = await localStorage.getItem("permission_token");
  } catch (e) {
    console.log(e);
  }

  const config = {
    method: "GET",
    headers: {
      "Content-Type": data ? "application/json" : "",
      ...headers,
      Authorization: token ? `${token}` : "",
    },
    ...customConfig,
  };
  if (config.method.toUpperCase() === "GET") {
    endpoint += `?${qs.stringify(data)}`;
  } else {
    config.body = JSON.stringify(data || {});
  }
  return fetch(`${baseUrl}${endpoint}`, config).then(res => res.json());
};

export const hanleError = (res: BaseResponse) => {
  if (res.code != 200) {
    Toast({
      message: res.msg || "出错拉",
      position: "bottom",
    });
    return false;
  }
  return res.data || true;
};
