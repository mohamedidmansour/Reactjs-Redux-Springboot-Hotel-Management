import React from 'react'

export default function Slide() {
    return (
        <div>
             <div class="section hero-full-height over-hide">

                <div class="home-moving-image"></div>
                <div class="dark-over-video"></div>

                <div class="hero-center-section ver-2">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-12 parallax-fade-top">
                                <div class="hero-text-ver-2">Pour la joie<br/>de vivre</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="section background-dark z-too-big">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="row justify-content-center home-translate">
                                <div class="col-xl-8">
                                    <div class="row justify-content-center home-shadow">
                                        <div class="col-md-9 px-sm-0">
                                            <div class="booking-sep-wrap">
                                                <div class="input-daterange input-group" id="flight-datepicker-1">
                                                    <div class="form-item">
                                                        <span class="fontawesome-calendar"></span>
                                                        <input class="input-sm" type="text" autoComplete="off" id="start-date" name="start" placeholder="date.Début" data-date-format="DD, MM d"/>
                                                        <span class="date-text date-depart"></span>
                                                    </div>
                                                    <div class="form-item">
                                                        <span class="fontawesome-calendar"></span>
                                                        <input class="input-sm" type="text" autoComplete="off" id="end-date" name="end" placeholder="date.Fin" data-date-format="DD, MM d"/>
                                                        <span class="date-text date-return"></span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        {/*<div class="col-md-3 px-sm-0">
                                            <div class="quantity">
                                                <input type="number" min="1" max="9999" step="1" defaultValue="1" />
                                            </div>
                                        </div>	*/}
                                        <div class="col-md-3 px-sm-0">
                                            <a class="booking-button-big" href="/ourRoom">Vérifier<br/>disponibilité</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
