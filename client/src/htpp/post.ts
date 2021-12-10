import store from "@/store";
import { hanleError, http } from ".";

/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-09 23:01:17
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-10 15:13:12
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

export const getPostDetail = async (postId: string) => {
  const res = await http("/post/information", {
    method: "GET",
    data: {
      postId,
    },
  });
  return hanleError(res);
};

export const getPostParticipant = async (postId: string) => {
  const res = await http("/post/participant", {
    method: "GET",
    data: {
      postId,
    },
  });
  return hanleError(res);
};

export const postJoinPost = async (obj: any) => {
  const res = await http("/apply", {
    method: "POST",
    data: obj,
  });
  return hanleError(res);
};
export const postCommentSt = async (obj: any) => {
  const res = await http("/comment_st", {
    method: "POST",
    data: obj,
  });
  return hanleError(res);
};
export const postCommentNd = async (obj: any) => {
  const res = await http("/comment_nd", {
    method: "POST",
    data: obj,
  });
  return hanleError(res);
};
// 一级评论
export const getCommentSt = async (
  pageSize: number,
  pageNum: number,
  postId: number
) => {
  const res = await http("/comment_st_get", {
    method: "get",
    data: {
      pageSize,
      pageNum,
      postId,
    },
  });
  return hanleError(res);
};

export const getApplicant = async () => {
  const res = await http("/post/applicant", {
    method: "GET",
    data: {
      userId: store.state.userId,
    },
  });
  return hanleError(res);
};

export const solvePost = async (
  postId: number,
  userId: number,
  flag: boolean
) => {
  const res = await http("/join/solve", {
    method: "POST",
    data: {
      userId,
      postId,
      flag,
    },
  });
  return hanleError(res);
};
