import React from "react";
import "./Select.css";
const Select = (props) => {
  const {
    id,
    name,
    defaultOption,
    value,
    label,
    options = [],
    error,
    onChange,
    onBlur,
  } = props;
  let className = "form-control form-select";

  if (error) {
    className += " is-invalid";
  }

  return (
    <div className="form-group my-2">
      {label && (
        <label className="form-label" htmlFor={id}>
          {label}
        </label>
      )}

      <select
        className={className}
        value={value}
        name={name}
        onChange={onChange}
        onBlur={onBlur}
      >
        {defaultOption ? (
          <option value={defaultOption.value} label={defaultOption.label} />
        ) : (
          <option value="" label="Bir seçim yapınız" />
        )}

        {options.map((option) => (
          <option
            className={`opt-${
              option.disabled && (option.disabled === "ACTIVE" ? false : true)
            }`}
            key={option.value}
            value={option.value}
            label={option.label}
            disabled={
              option.disabled && (option.disabled === "ACTIVE" ? false : true)
            }
          />
        ))}
      </select>

      {error && <div className="invalid-feedback">{error}</div>}
    </div>
  );
};

export default Select;
