import React, {Component} from 'react';

class Gallery extends Component {
    render() {
        return (
            <div>

                <div class="section big-55-height over-hide z-bigger">

                    <div class="parallax parallax-top" style={{backgroundImage: 'url(img/rooms.jpg)'}}></div>
                    <div class="dark-over-pages"></div>

                    <div class="hero-center-section pages">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-12 parallax-fade-top">
                                    <div class="hero-text">Gallery</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="section padding-top-bottom-smaller background-dark-2 over-hide">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <h5 class="color-grey">A new dimension of luxury.</h5>
                                <p class="color-white mt-3 mb-3"><em>our presentation, 0:48 min</em></p>
                                <a href="https://vimeo.com/54851233" class="video-button" data-fancybox><i
                                    class="fa fa-play"></i></a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="section padding-top-bottom over-hide">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-md-8 align-self-center">
                                <div class="subtitle with-line text-center mb-4">Gallery</div>
                                <h3 class="text-center padding-bottom-small">Nos Chambres</h3>
                            </div>
                            <div class="section clearfix"></div>
                            <div class="col-md-4">
                                <a href="img/gallery/1.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/1-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4 mt-md-0">
                                <a href="img/gallery/2.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/2-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4 mt-md-0">
                                <a href="img/gallery/3.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/3-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4">
                                <a href="img/gallery/4.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/4-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4">
                                <a href="img/gallery/5.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/5-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4">
                                <a href="img/gallery/6.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/6-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4">
                                <a href="img/gallery/7.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/7-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4">
                                <a href="img/gallery/8.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/8-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                            <div class="col-md-4 mt-4">
                                <a href="img/gallery/9.jpg" data-fancybox="gallery">
                                    <div class="img-wrap gallery-small">
                                        <img src="img/gallery/9-s.jpg" alt=""/>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="section padding-top-bottom-big over-hide">
                    <div class="parallax" style={{backgroundImage: 'url(img/5.jpg)'}}></div>
                    <div class="section z-bigger">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-md-8">
                                    <div id="owl-sep-1" class="owl-carousel owl-theme">
                                        <div class="item">
                                            <div class="quote-sep">
                                                <h4>"Chilling out on the bed in your hotel room watching television,
                                                    while wearing your own pajamas, is sometimes the best part of a
                                                    vacation."</h4>
                                                <h6>Jason Salvatore</h6>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <div class="quote-sep">
                                                <h4>"Every good day starts off with a cappuccino, and there's no place
                                                    better to enjoy some frothy caffeine than at the Thalia Hotel."</h4>
                                                <h6>Terry Mitchell</h6>
                                            </div>
                                        </div>
                                        <div class="item">
                                            <div class="quote-sep">
                                                <h4>"I still enjoy traveling a lot. I mean, it amazes me that I still
                                                    get excited in hotel rooms just to see what kind of shampoo they've
                                                    left me."</h4>
                                                <h6>Michael Brighton</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="scroll-to-top"></div>
            </div>
        );
    }
}

export default Gallery;