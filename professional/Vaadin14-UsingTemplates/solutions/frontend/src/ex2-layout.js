import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
class Ex2LayoutTemplate extends PolymerElement {
  static get template() {
    return html`
   <h1>I'm Header</h1>

   <div>
    <slot>
     content area
    </slot>
   </div> 
   <h1>I'm Footer</h1> 
`;
  }

  static get is() { return 'ex2-layout' }
}
customElements.define(Ex2LayoutTemplate.is, Ex2LayoutTemplate);

