import { UserInfoProp } from "@/types/types";
import { http, hanleError } from ".";

/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-08 20:31:11
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-10 01:07:08
 * @Description:
 */
export interface LoginProp {
  userName: string;
  password: string;
}

export const postLogin = async (user: LoginProp) => {
  const data = await http("/login", {
    method: "POST",
    data: user,
  });
  return hanleError(data);
};

// 判断是否重名
export const alreadyUsername = async (userName: string) => {
  const data = await http("/already", {
    method: "GET",
    data: {
      userName,
    },
  });
  return hanleError(data);
};

export const postRegister = async (user: LoginProp) => {
  const data = await http("/register", {
    method: "POST",
    data: user,
  });
  return hanleError(data);
};
// 更新用户信息
export const postUpdateProfile = async (user: UserInfoProp) => {
  const data = await http("/user/update", {
    method: "post",
    data: user,
  });
  return hanleError(data);
};

export const getUserInfo = (userId: string) => {
  return http("/user_search", {
    method: "GET",
    data: { userId },
  });
};
