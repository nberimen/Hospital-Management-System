import React from "react";

const ButtonWithProgress = (props) => {
  const { onClick, pendingApiCall, disabled, text, className, icon } = props;
  return (
    <button
      className={className || "btn btn-primary"}
      onClick={onClick}
      disabled={disabled}
      type="submit"
    >
      {icon && icon}
      {pendingApiCall && (
        <span className="spinner-border spinner-border-sm text-light"></span>
      )}
      <span> {text}</span>
    </button>
  );
};

export default ButtonWithProgress;
