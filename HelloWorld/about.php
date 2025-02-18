<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>About Us</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rouge+Script&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@400;700&display=swap" rel="stylesheet">
        <style>
            h1,h2 {
                font-family: "Pacifico", cursive;
                font-weight: 400;
                font-style: normal;
            }
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-image: url('sunflower.jpg');
            }
            .background-image {
                background-image: url('daisies.jpg');
                background-size: cover;
                background-repeat: no-repeat;
                background-position: top;
                padding-top: 100px;
            }
            header {
                background-color: #f8f3e8;
                color: #333;
                padding: 20px;
                text-align: center;
            }
            section {
                padding: 20px;
                max-width: 800px;
                margin: 0 auto;
                margin-left: 50px;
            }
            p {
                line-height: 1.6;
                margin-bottom: 20px;
            }
            .php-section {
                text-align: center;
                margin-top: 20px;
                font-family: 'Rouge Script', cursive;
                font-size: 30px;
            }

            .loop-statement {
                margin-left: 50px;
                margin-top: 20px;
                font-size: 20px;
                font-family: "Amatic SC", sans-serif;
                font-weight: 900;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Welcome to LensCraft</h1>
            <h3>Your premier destination for high-quality lenses and frames, customized for your personal preferences</h3>
        </header>
        <div class="background-image">
            <section>
                <h2>About Us</h2>
                <h3>We are a team of passionate individuals dedicated to providing user-friendly frames and lenses at an affordable rate, delivered right to your doorstep. At Lenscraft, we prioritize customer comfort and ease of access while staying up-to-date with the latest trends in fashion and accessories.</h3>
                <h3>Whether you're looking for prescription glasses, fashionable sunglasses, or custom lens frames, we have something for everyone. Our user-friendly website and intuitive browsing experience make it easy for you to find the perfect pair of eyewear that complements your unique style and personality.</h3>
            </section>
            <div class="php-section">
                <?php
                echo 'Experience the Lenscraft difference today and discover a new way to see the world.<br><br><br>';
                ?>
            </div>
            <div class="loop-statement">
                <?php
                echo "Store branches present in ";
                $statements = [
                    "Delhi",
                    "Bangalore",
                    "Mumbai",
                    "Ahmedabad",
                    "Chennai"
                ];

                $output = "";
                for ($i = 0; $i < count($statements); $i++) {
                    $output .= $statements[$i];
                    if ($i < count($statements) - 1) {
                        $output .= ", ";
                    }
                }
                echo $output;
                ?>
            </div>
        </div>
    </body>
</html>