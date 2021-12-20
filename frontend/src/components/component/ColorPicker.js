import React, {useState} from "react";
import { HexColorPicker, RgbaColorPicker } from "react-colorful";
import "../../color_picker.css";

export default function App() {

  return (
    <div className="App">
      <h2>Select Color</h2>
      <section className="resposive example">
      </section>
      <h2>Small</h2>
      <section className="small example">
        <HexColorPicker />
      </section>

      <h2>Custom pointers</h2>
      <section className="custom-pointers example">
        <RgbaColorPicker />
      </section>

      <h2>Custom layout</h2>
      <section className="custom-layout example">
        <RgbaColorPicker />
      </section>
    </div>
  );
}
