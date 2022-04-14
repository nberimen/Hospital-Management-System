import React from "react";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as MdIcons from "react-icons/md";
import * as HiIcons from "react-icons/hi";

export const SidebarDataAdmin = [
  {
    title: "Home",
    path: "/",
    icon: <AiIcons.AiFillHome />,
    cName: "nav-text",
  },
  {
    title: "Doctor List",
    path: "/doctor-list",
    icon: <FaIcons.FaUsers />,
    cName: "nav-text",
  },
  {
    title: "Patient List",
    path: "/patient-list",
    icon: <FaIcons.FaUsers />,
    cName: "nav-text",
  },
  {
    title: "Appointment Details",
    path: "/appointment-details",
    icon: <MdIcons.MdOutlineAttachment />,
    cName: "nav-text",
  },
  {
    title: "Add Doctor",
    path: "/add-doctor",
    icon: <AiIcons.AiOutlineUserAdd />,
    cName: "nav-text",
  },
  {
    title: "Delete Doctor",
    path: "/delete-doctor",
    icon: <HiIcons.HiUserRemove />,
    cName: "nav-text",
  },
];

export const SidebarDataDoctor = [
  {
    title: "Home",
    path: "/",
    icon: <AiIcons.AiFillHome />,
    cName: "nav-text",
  },
  {
    title: "Appointments",
    path: "/appointments",
    icon: <FaIcons.FaUsers />,
    cName: "nav-text",
  },
];

export const SidebarDataPatient = [
  {
    title: "Home",
    path: "/",
    icon: <AiIcons.AiFillHome />,
    cName: "nav-text",
  },
  {
    title: "Book Appointment",
    path: "/appointment-list",
    icon: <FaIcons.FaUsers />,
    cName: "nav-text",
  },
  {
    title: "Appointment History",
    path: "/appointment-history",
    icon: <FaIcons.FaUsers />,
    cName: "nav-text",
  },
];
