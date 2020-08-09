import React from 'react'
import Header from './../Header/Header';
import Footer from './../Footer/Footer';
import Slide from './../Header/Slide';
import { Url } from 'url';

export default function Contact() {
    return (	
        <div >
            <Header/>
            <div class="section big-55-height over-hide z-bigger">
                <div class="parallax parallax-top" style={{backgroundImage: `url(img/gallery/10.jpg)`}}></div>
                <div class="dark-over-pages"></div>
            
                <div class="hero-center-section pages">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-12 parallax-fade-top">
                                <div class="hero-text">Contact</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section padding-top z-bigger">
                <div class="container">
                    <div class="row justify-content-center padding-bottom-smaller">
                        <div class="col-md-8">
                            <div class="subtitle with-line text-center mb-4">contact</div>
                            <h3 class="text-center padding-bottom-small">drop us a line</h3>
                        </div>
                        <div class="section clearfix"></div>
                        <div class="col-md-4 ajax-form">
                            <input name="name" type="text" placeholder="Your Name: *" autocomplete="off"/>
                        </div>
                        <div class="col-md-4 mt-4 mt-md-0 ajax-form">
                            <input name="email" type="text"  placeholder="E-Mail: *" autocomplete="off"/>
                        </div>
                        <div class="section clearfix"></div>
                        <div class="col-md-8 mt-4 ajax-form">
                            <textarea name="message" placeholder="Tell Us Everything"></textarea>
                        </div>
                        <div class="section clearfix"></div>
                        <div class="col-md-8 mt-3 ajax-checkbox">
                            <ul class="list">
                                <li class="list__item">
                                    <label class="label--checkbox">
                                        <input type="checkbox" class="checkbox"/>
                                        collect my details through this form
                                    </label>
                                </li>
                            </ul>
                        </div>
                        <div class="section clearfix"></div>
                        <div class="col-md-8 mt-3 ajax-form text-center">
                            <button class="send_message" id="send" data-lang="en"><span>submit</span></button>
                        </div>
                        <div class="section clearfix"></div>
                        <div class="col-md-8 padding-top-bottom">
                            <div class="sep-line"></div>
                        </div>
                    </div>
                </div>	
            </div>
            <Footer/>	
        </div>
    )
}
