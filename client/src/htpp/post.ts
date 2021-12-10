import { hanleError, http } from ".";

/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-09 23:01:17
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-10 00:39:59
 * @Description:
 */
export const getBallList = async () => {
  const data = await http("/ball", {
    method: "GET",
  });
  return hanleError(data);
};

export const addPost = async (obj: any) => {
  const res = await http("/post", {
    method: "POST",
    data: obj,
  });
  return hanleError(res);
};

export const getPostList = async (pageSize: number, pageNum: number) => {
  const res = await http("/post/home", {
    method: "GET",
    data: {
      pageSize,
      pageNum,
    },
  });
  return res.data;
};

