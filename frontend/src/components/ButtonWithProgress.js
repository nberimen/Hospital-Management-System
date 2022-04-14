import React from 'react'

const ButtonWithProgress = (props) => {
    const {onClick, pendingApiCall, disabled, text, className} = props;
    return (
        <button
            className={className || "btn btn-primary"}
            onClick={onClick}
            disabled={disabled}
            type="submit"
        >
            {pendingApiCall && <span className="spinner-border spinner-border-sm text-light"></span>}
            {text}
        </button>
    )
}

export default ButtonWithProgress