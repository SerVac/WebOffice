var path = require('path'),
    webpack = require('webpack'),
    ExtractTextPlugin = require("extract-text-webpack-plugin");

var node_dir = __dirname + '/node_modules';


module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/bundle.js'
    },
    module: {
        rules: [
            // {
            //     test: /\.(ttf|otf|eot|svg|woff(2)?)(\?[a-z0-9]+)?$/,
            //         use: 'file-loader?name=fonts/[name].[ext]'
            // },
            /*{
             test: /\.(png|woff|woff2|eot|ttf|svg)$/,
             // test: /\.(ttf|otf|eot|svg|woff(2)?)(\?[a-z0-9]+)?$/,
             use: 'url-loader?limit=100000'
             },*/
            /* {
             test: /bootstrap\/dist\/js\/umd\//,
             use: 'imports-loader?jQuery=jquery'
             },*/
            {
                test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                loader: "url-loader?limit=10000&mimetype=application/font-woff"
            },
            {
                test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {
                            outputPath: './src/main/resources/static/'
                        }
                    }
                ]
            },
            {
                test: /\.(s(ass|css))$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    // use: ['css-loader', 'sass-loader']
                    use: [
                        {loader: 'css-loader'},
                        {
                            loader: 'postcss-loader',
                            options: {
                                plugins: function () { // post css plugins, can be exported to postcss.config.js
                                    return [
                                        require('precss'),
                                        require('autoprefixer')
                                    ];
                                }
                            }
                        },
                        {
                            loader: "sass-loader",
                            options: {
                                includePaths: [node_dir]
                            }
                        },
                    ]
                })
            }
            , {
                test: /\.css$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader']
                })
            }
        ]

    },
    plugins: [
        new ExtractTextPlugin({
            filename: './src/main/resources/static/css/style.css'
        }),
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.jQuery': 'jquery',
            Popper: ['popper.js', 'default'],
            Util: "exports-loader?Util!bootstrap/js/dist/util",
            Dropdown: "exports-loader?Dropdown!bootstrap/js/dist/dropdown"
        })
    ]
};