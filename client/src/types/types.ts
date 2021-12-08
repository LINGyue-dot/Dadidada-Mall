/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-07 17:18:13
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-08 21:51:06
 * @Description:
 */
export interface BaseResponse {
  code: string | number;
  msg: string | null;
  data: any;
}

export interface UserInfoProp {
  userId: string;
  userName: string;
  userPassword: string;
  userAvatar: string;
  userSex: "male" | "female";
  userHeight: number;
  userWeight: number;
  userAge: number;
  userSpecialty: string;
  userIntroduction: "asd";
  userIdentity: "teacher" | "other" | "student";
}
